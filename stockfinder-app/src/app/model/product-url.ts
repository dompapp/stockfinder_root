import {Product} from './product';

export interface ProductUrl {
  productUrlId: number | undefined;
  productUri: string | undefined;
  product: Product | undefined;
}
