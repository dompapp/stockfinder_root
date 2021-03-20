import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ProductUrl} from '../model/product-url';
import {Observable} from 'rxjs';

@Injectable()
export class ProductUrlService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/urls';
  }

  public findAll(): Observable<ProductUrl[]> {
    return this.http.get<ProductUrl[]>(this.url);
  }

  public save(productUrl: ProductUrl) {
    return this.http.post<ProductUrl>(this.url, productUrl);
  }

}
