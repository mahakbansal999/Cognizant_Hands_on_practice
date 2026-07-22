import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);

    this.items = [
      { itemname: "Laptop", price: 50000 },
      { itemname: "Mobile", price: 25000 },
      { itemname: "Headphones", price: 2000 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Mouse", price: 800 }
    ];
  }

  render() {
    return (
      <div>
        <h1>Online Shopping Cart</h1>

        {this.items.map((item, index) => (
          <Cart
            key={index}
            itemname={item.itemname}
            price={item.price}
          />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
