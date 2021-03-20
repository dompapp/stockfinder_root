import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
// tslint:disable-next-line:import-blacklist
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable()
export class ProductService {

  private productUrl: string;

  constructor(private http: HttpClient) {
    this.productUrl = 'http://localhost:8080/products';
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

  public save(product: Product) {
    return this.http.post<Product>(this.productUrl, product);
  }

}
