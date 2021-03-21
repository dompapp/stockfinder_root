import {Product} from '../model/product';

export class ProductUtil {

  public static createProduct(): Product {
    return {
      productId: -1,
      productName: '',
      productMaxPrice: 0.00,
      manufacturer: undefined
    };
  }

}
