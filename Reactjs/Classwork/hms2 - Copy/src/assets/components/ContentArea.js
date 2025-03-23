import React from 'react';

function ContentArea({ activeContent }) {
  // Sample content components - in a real application, you would have actual components
  const renderContent = () => {
    if (activeContent === 'dashboard') {
      return (
        <div className="dashboard-content">
          <h2>Welcome to the Dashboard</h2>
          <p>Select an option from the menu to view its content.</p>
          <div className="dashboard-cards">
            <div className="card">
              <h3>Quick Stats</h3>
              <p>View your system statistics at a glance</p>
            </div>
            <div className="card">
              <h3>Recent Activity</h3>
              <p>See the latest actions and updates</p>
            </div>
            <div className="card">
              <h3>Notifications</h3>
              <p>Check important alerts and messages</p>
            </div>
          </div>
        </div>
      );
    }
    
    // For dynamically loaded content based on menu selection
    return (
      <div className="dynamic-content">
        <h2>Content: {activeContent}</h2>
        <p>This is the content area for {activeContent}.</p>
        <form className="sample-form">
          <div className="form-group">
            <label htmlFor="name">Name:</label>
            <input type="text" id="name" name="name" />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input type="email" id="email" name="email" />
          </div>
          <div className="form-group">
            <label htmlFor="message">Message:</label>
            <textarea id="message" name="message" rows="4"></textarea>
          </div>
          <button type="submit" className="submit-btn">Submit</button>
        </form>
      </div>
    );
  };

  return (
    <main className="content-area">
      {renderContent()}
    </main>
  );
}

export default ContentArea;

