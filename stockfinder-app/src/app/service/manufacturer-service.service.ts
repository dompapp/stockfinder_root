import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {Manufacturer} from '../model/manufacturer';

@Injectable()
export class ManufacturerService {

  private manufacturerUrl: string;

  constructor(private http: HttpClient) {
    this.manufacturerUrl = 'http://localhost:8080/manufacturers';
  }

  public findAll(): Observable<Manufacturer[]> {
    return this.http.get<Manufacturer[]>(this.manufacturerUrl);
  }

  public save(manufacturer: Manufacturer) {
    return this.http.post<Manufacturer>(this.manufacturerUrl, manufacturer);
  }

}
