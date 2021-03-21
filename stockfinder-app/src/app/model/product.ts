import {Manufacturer} from './manufacturer';

export class Product {
  productId: number | undefined;
  productName: string | undefined;
  productMaxPrice: number | undefined;
  manufacturer: Manufacturer | undefined;
}
