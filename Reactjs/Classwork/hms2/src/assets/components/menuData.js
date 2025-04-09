export const menuItems = [
    {
      label: "Dashboard",
      path: "/dashboard",
    },
    {
      label: "Master",
      submenus: [
        { label: "Admin Users", path: "/admin-users" },
        { label: "Other Users", path: "/other-users" },
        { label: "Departments", path: "/admin-departments" },
        { label: "Designations", path: "/admin-designations" },
        { label: "Roles", path: "/roles" },
        { label: "Master 3", path: "/master3" },
      ],
    },
    {
      label: "Hospital Services",
      submenus: [
        {
          label: "Doctor Scheduling",
          submenus: [
            { label: "Morning Shift", path: "/morning-shift" },
            { label: "Evening Shift", path: "/evening-shift" },
          ],
        },
        {
          label: "Shifts",
          submenus: [{ label: "Night Shift", path: "/night-shift" }],
        },
      ],
    },
  ];
  