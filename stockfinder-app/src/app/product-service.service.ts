import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./user";

@Injectable()
export class ProductServiceService {

  private productUrl: string;

  constructor(private http: HttpClient) {
    this.productUrl = 'http://localhost:8080/product';
  }

  public findAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productUrl);
  }

  public save(user: Product) {
    return this.http.post<Product>(this.productUrl, user);
  }

}
