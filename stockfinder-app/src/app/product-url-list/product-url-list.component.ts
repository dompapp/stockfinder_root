import {Component, OnInit} from '@angular/core';
import {ProductUrl} from '../model/product-url';
import {ProductUrlService} from '../service/product-url.service';

@Component({
  selector: 'app-product-url-list',
  templateUrl: './product-url-list.component.html',
  styleUrls: ['./product-url-list.component.css']
})
export class ProductUrlListComponent implements OnInit {

  urls: ProductUrl[];

  constructor(private productUrlService: ProductUrlService) {
  }

  ngOnInit() {
    this.productUrlService.findAll().subscribe(data => {
      this.urls = data;
    });
  }
}
