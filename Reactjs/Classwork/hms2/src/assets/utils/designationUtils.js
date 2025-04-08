import { getDesignations } from '../components/DesignationService';

export const loadDesignations = async (
  setDesignations,
  setTotalPages,
  search = '',
  page = 0,
  size = 5,
  sortField = 'designationname',
  sortDir = 'asc',
  setErrorMsg,
  setLoading // ⬅️ new optional parameter
) => {
  if (setLoading) setLoading(true); // optional spinner
  try {
    const res = await getDesignations(search, page, size, sortField, sortDir);
    setDesignations(res.data.content);
    setTotalPages(res.data.totalPages);
  } catch (error) {
    console.error(error);
    setErrorMsg('Failed to load data');
  } finally {
    if (setLoading) setLoading(false); // end spinner
  }
};
