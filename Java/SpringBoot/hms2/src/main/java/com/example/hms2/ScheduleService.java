package com.example.hms2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ScheduleService {

    @Autowired private ScheduleRepository scheduleRepository;
    @Autowired private OtherUserRepository userRepository;
    @Autowired private DesignationRepository designationRepository;

    public Page<ScheduleDTO> getAllSchedules(String search, int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));

        Page<Schedule> schedules;
        if (search != null && !search.trim().isEmpty()) {
            schedules = scheduleRepository.findByAttendanceContaining(search.trim(), pageable);
        } else {
            schedules = scheduleRepository.findAll(pageable);
        }

        return schedules.map(this::convertToDTO);
    }

    public void saveSchedule(ScheduleDTO dto) {
        validateScheduleTimes(dto);
        Schedule schedule = new Schedule();
        mapDTOToEntity(dto, schedule);
        schedule.setLasteditdatetime(LocalDateTime.now());
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(Long id, ScheduleDTO dto) {
        Schedule schedule = scheduleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id));
        validateScheduleTimes(dto);
        mapDTOToEntity(dto, schedule);
        schedule.setLasteditdatetime(LocalDateTime.now());
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public ScheduleDTO getScheduleById(Long id) {
        return convertToDTO(scheduleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Schedule not found with id: " + id)));
    }

    private void mapDTOToEntity(ScheduleDTO dto, Schedule schedule) {
        schedule.setUser(userRepository.findById(dto.getSchuserid()).orElseThrow());
        schedule.setDesignation(designationRepository.findById(dto.getSchdesignationid()).orElseThrow());
        schedule.setScheduledate(LocalDate.parse(dto.getScheduledate()));
        schedule.setFromtime(LocalTime.parse(dto.getFromtime()));
        schedule.setTotime(LocalTime.parse(dto.getTotime()));
        schedule.setAttendance(dto.getAttendance());
        schedule.setLastaddeditby(dto.getLastaddeditby());
    }

    private ScheduleDTO convertToDTO(Schedule s) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setSchid(s.getSchid());
        dto.setSchuserid(s.getUser().getOuserid());
        dto.setOusername(s.getUser().getOusername());
        dto.setSchdesignationid(s.getDesignation().getDesignationid());
        dto.setDesignationname(s.getDesignation().getDesignationname());
        dto.setScheduledate(s.getScheduledate().toString());
        dto.setFromtime(s.getFromtime().toString());
        dto.setTotime(s.getTotime().toString());
        dto.setAttendance(s.getAttendance());
        dto.setLastaddeditby(s.getLastaddeditby());
        return dto;
    }

    private void validateScheduleTimes(ScheduleDTO dto) {
        if (dto.getScheduledate() == null || dto.getScheduledate().trim().isEmpty()) {
            throw new IllegalArgumentException("Scheduled date is required.");
        }

        LocalDate date = LocalDate.parse(dto.getScheduledate());
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date must be in the future.");
        }

        if (dto.getFromtime() == null || dto.getFromtime().trim().isEmpty() ||
            dto.getTotime() == null || dto.getTotime().trim().isEmpty()) {
            throw new IllegalArgumentException("From time and To time are required.");
        }

        LocalTime from = LocalTime.parse(dto.getFromtime());
        LocalTime to = LocalTime.parse(dto.getTotime());

        if (to.isBefore(from) || Duration.between(from, to).toHours() < 8) {
            throw new IllegalArgumentException("There must be at least 8 hours between fromtime and totime, and totime must be later than fromtime.");
        }
    }
    
    public Map<String, Object> searchSchedulesByNameOrDesignation(String keyword, int page, int size) {
        List<ScheduleDTO> all = scheduleRepository.findAll()
            .stream()
            .map(this::convertToDTO)
            .toList();

        List<ScheduleDTO> filtered = all.stream()
            .filter(s -> {
                String uname = s.getOusername() != null ? s.getOusername().toLowerCase() : "";
                String dname = s.getDesignationname() != null ? s.getDesignationname().toLowerCase() : "";
                return uname.contains(keyword.toLowerCase()) || dname.contains(keyword.toLowerCase());
            })
            .toList();

        int total = filtered.size();
        int fromIndex = Math.min(page * size, total);
        int toIndex = Math.min(fromIndex + size, total);

        List<ScheduleDTO> paginated = filtered.subList(fromIndex, toIndex);

        return Map.of(
            "content", paginated,
            "totalPages", (int) Math.ceil((double) total / size)
        );
    }
    
}
