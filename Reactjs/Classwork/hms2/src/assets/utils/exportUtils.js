import * as XLSX from 'xlsx';
import { saveAs } from 'file-saver';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

export const exportToExcel = (data, filename = 'designations.xlsx') => {
  const worksheet = XLSX.utils.json_to_sheet(data);
  const workbook = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(workbook, worksheet, 'Designations');
  const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
  const blob = new Blob([excelBuffer], { type: 'application/octet-stream' });
  saveAs(blob, filename);
};

export const exportToPDF = (data, filename = 'designations.pdf') => {
  const doc = new jsPDF();
  doc.autoTable({
    head: [['ID', 'Designation Name']],
    body: data.map(d => [d.designationid, d.designationname]),
  });
  doc.save(filename);
};
