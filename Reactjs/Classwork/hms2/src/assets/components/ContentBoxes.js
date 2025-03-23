import React from "react";

const ContentBoxes = () => {
    return (
        <div className="grid grid-cols-2 gap-4 p-4">
          <div className="bg-blue-200 p-6 rounded-lg shadow-md text-center border border-gray-400">
            <h2 className="text-lg font-bold">Patient Management</h2>
            <p>Efficiently manage patient records and appointments.</p>
          </div>
          <div className="bg-green-200 p-6 rounded-lg shadow-md text-center border border-gray-400">
            <h2 className="text-lg font-bold">Doctor Scheduling</h2>
            <p>Organize doctor shifts and availability seamlessly.</p>
          </div>
          <div className="bg-yellow-200 p-6 rounded-lg shadow-md text-center border border-gray-400">
            <h2 className="text-lg font-bold">Billing & Payments</h2>
            <p>Handle invoices, insurance, and payments with ease.</p>
          </div>
          {/* <div className="bg-red-200 p-6 rounded-lg shadow-md text-center border border-gray-400">
            <h2 className="text-lg font-bold">Reports & Analytics</h2>
            <p>Generate insightful reports for better decision-making.</p>
          </div> */}
        </div>
      );
};

export default ContentBoxes;
