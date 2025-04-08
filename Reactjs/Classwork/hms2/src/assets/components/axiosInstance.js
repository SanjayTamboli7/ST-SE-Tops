import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api',
});

axiosInstance.interceptors.response.use(
  res => res,
  async error => {
    const config = error.config;
    if (!config || config.__retryCount >= 3) {
      return Promise.reject(error);
    }

    config.__retryCount = config.__retryCount ? config.__retryCount + 1 : 1;

    // Retry after 1 second
    await new Promise(res => setTimeout(res, 1000));
    return axiosInstance(config);
  }
);

export default axiosInstance;
