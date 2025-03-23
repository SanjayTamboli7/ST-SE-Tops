import React from "react";

const ECommHomePage = () => {
  return (
    <div className="bg-gray-100 min-h-screen">
      {/* Navbar */}
      <nav className="bg-white shadow-md p-4 flex justify-between items-center">
        <h1 className="text-2xl font-bold">ShopMate</h1>
        <div>
          <button className="mr-4">Login</button>
          <button className="bg-blue-600 text-white px-4 py-2 rounded">Sign Up</button>
        </div>
      </nav>

      {/* Hero Section */}
      <header className="bg-blue-600 text-white text-center py-16">
        <h2 className="text-4xl font-bold">Discover Amazing Products</h2>
        <p className="mt-4">Find the best deals on all your favorite items.</p>
        <button className="mt-6 bg-white text-blue-600 px-6 py-2 rounded font-semibold">
          Shop Now
        </button>
      </header>

      {/* Product Listings */}
      <section className="container mx-auto p-6">
        <h3 className="text-2xl font-bold mb-4">Featured Products</h3>
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
          {[1, 2, 3].map((product) => (
            <div key={product} className="bg-white p-4 shadow-lg rounded-lg">
              <img
                src="https://via.placeholder.com/200"
                alt="Product"
                className="w-full h-40 object-cover rounded"
              />
              <h4 className="text-lg font-semibold mt-2">Product {product}</h4>
              <p className="text-gray-600">$99.99</p>
              <button className="mt-2 bg-blue-600 text-white px-4 py-2 rounded w-full">
                Add to Cart
              </button>
            </div>
          ))}
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-gray-800 text-white text-center p-4 mt-6">
        <p>&copy; 2025 ShopMate. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default ECommHomePage;
