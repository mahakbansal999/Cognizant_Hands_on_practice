import React, { Component } from "react";

class Cart extends Component {
  render() {
    return (
      <div>
        <h3>Item Name: {this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

export default Cart;