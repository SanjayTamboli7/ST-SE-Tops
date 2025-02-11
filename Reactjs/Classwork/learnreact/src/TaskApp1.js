//c import { useReducer } from 'react';
import AddTask1 from './AddTask1.js';
import TaskList1 from './TaskList1.js';
import { TasksProvider } from './TasksContext.js';

export default function TaskApp1() {
  return (
    <TasksProvider>
      <h1>Day off in Kyoto</h1>
      <AddTask1 />
      <TaskList1 />
    </TasksProvider>
  );
}
