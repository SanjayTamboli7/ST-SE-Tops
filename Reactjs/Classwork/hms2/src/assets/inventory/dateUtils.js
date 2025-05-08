export const getTodayDate = () => {
    const today = new Date();
    return today.toISOString().split('T')[0];
  };
  
  export const getCurrentDateTime = () => {
    return new Date().toISOString();
  };
  