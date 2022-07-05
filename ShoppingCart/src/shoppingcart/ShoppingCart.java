package shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;
import products.Product;

public class ShoppingCart {
	ArrayList<CartLine> cartLines = new ArrayList<CartLine>();

	public void addProduct(Product product) {
		for (CartLine cartLine : cartLines) {
			if (cartLine.getProduct().getProductnumber().equals(product.getProductnumber())) {
				cartLine.setQuantity(cartLine.getQuantity() + 1);
				return;
			}
		}
		CartLine cartLine = new CartLine();
		cartLine.setProduct(product);
		cartLine.setQuantity(1);
		cartLines.add(cartLine);
	}

	public void printProduct() {
		System.out.println("Content of the shoppingcart:");
		for (CartLine cartLine : cartLines) {
			System.out.println(cartLine.getQuantity() + " "
					+ cartLine.getProduct().getProductnumber() + " "
					+ cartLine.getProduct().getDescription() + " "
					+ cartLine.getProduct().getPrice());
		}
		System.out.println("Total price = " + getTotalPrice());
	}

	public void removeProduct(Product product) {
		Iterator<CartLine> iter = cartLines.iterator();
		while (iter.hasNext()) {
			CartLine cartLine = iter.next();
			if (cartLine.getProduct().getProductnumber().equals(product.getProductnumber())) {
				if (cartLine.getQuantity() > 1) {
					cartLine.setQuantity(cartLine.getQuantity() - 1);
				} else {
					iter.remove();
				}
			}
		}
	}

	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (CartLine cartLine : cartLines) {
			totalPrice = totalPrice + (cartLine.getProduct().getPrice() * cartLine.getQuantity());
		}
		return totalPrice;
	}
}