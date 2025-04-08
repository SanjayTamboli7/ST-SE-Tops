package com.example.hms2;

// import java.lang.System.Logger;
import java.time.LocalDateTime;
import java.util.Optional;

// import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);


    @Autowired
    private DepartmentRepository departmentRepository;

	@Autowired(required = false)  // Mark as optional to prevent startup errors
    private AdminUserCRUDRepository adminUserCRURepository;

//    public Page<Department> getDepartments(String search, Pageable pageable) {
//        return departmentRepository.searchDepartments(search, pageable);
//    }

	public Page<Department> getDepartments(String search, Pageable pageable) {
		System.out.println("Requested Page: " + pageable.getPageNumber());
		System.out.println("Page Size: " + pageable.getPageSize());
		return departmentRepository.searchDepartments(search, pageable);
	}
	
    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }
        
//    public Department saveDepartment(Department department) {  
//        // Verify user exists
//        if (!adminUserRepository.existsById(department.getLastaddeditby())) {
//            throw new IllegalArgumentException("User ID " + department.getLastaddeditby() + " does not exist");
//        }
//        // Get current authenticated user
//        // AdminUser currentUser = getCurrentAuthenticatedUser();
//        // department.setLastaddeditby(currentUser.getAuserid());        
//        return departmentRepository.save(department);
//    }

    public Department saveDepartment(Department department) {  
        // Comment this validation temporarily if adminUserRepository isn't set up yet
        if (adminUserCRURepository != null) {
            // Only validate if repository is available
            if (!adminUserCRURepository.existsById(department.getLastaddeditby())) {
                throw new IllegalArgumentException("User ID " + department.getLastaddeditby() + " does not exist");
            }
        } else {
            // Log the issue but continue saving
            System.out.println("Warning: AdminUserRepository is null, skipping user validation");
        }
        department.setLasteditdatetime(LocalDateTime.now());

    	try {
            logger.info("Attempting to save department: {}", department.getDeptname());
            // Your existing code...
            return departmentRepository.save(department);
        } catch (Exception e) {
            logger.error("Error saving department: {}", e.getMessage(), e);
            throw e;
        }    	
//        return departmentRepository.save(department);
    }    
    public Department updateDepartment(int id, Department department) {
    	department.setLasteditdatetime(LocalDateTime.now());
        department.setDeptid(id);
        return departmentRepository.save(department);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
