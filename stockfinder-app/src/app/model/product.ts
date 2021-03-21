import {Manufacturer} from './manufacturer';

export interface Product {
  productId: number | undefined;
  productName: string | undefined;
  productMaxPrice: number | undefined;
  manufacturer: Manufacturer | undefined;
}
