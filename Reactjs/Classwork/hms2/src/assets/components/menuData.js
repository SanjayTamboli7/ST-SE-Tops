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
        { label: "Holidays", path: "/admin-holidays" },
        { label: "Item Category", path: "/item-category" },
        { label: "Item Unit", path: "/item-unit" },
        { label: "Item", path: "/item" },
        { label: "Supplier", path: "/supplier" },
        { label: "Supplier-Item", path: "/supplier-item" },
        { label: "Roles", path: "/roles" },
        { label: "Master 3", path: "/master3" },
      ],
    },
    {
      label: "Transaction",
      submenus: [
        { label: "Leave", path: "/leave" },
        { label: "Schedule", path: "/schedule" },
      ],
    },
    {
      label: "Inventory",
      submenus: [
        { label: "Purchase Request", path: "/purchase-request" },
        { label: "Purchase Order", path: "/purchase-order" },
        { label: "Goods Received Note", path: "/goodsreceivednote" },
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
  