
import {Component, OnInit} from '@angular/core';
import {ProductUrl} from '../model/product-url';
import {ProductUrlService} from '../service/product-url.service';

@Component({
  selector: 'app-product-url-list',
  templateUrl: './product-url-list.component.html',
  styleUrls: ['./product-url-list.component.css']
})
export class ProductUrlListComponent implements OnInit {

  displayedColumns: string[] = ['manufacturer', 'product', 'url'];
  urls: ProductUrl[] = [];

  constructor(private productUrlService: ProductUrlService) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.productUrlService.findAll().subscribe(data => {
      if (data !== undefined) {
        this.urls = data;
      }},
      (error: any) => console.log(error)
    );
  }

  printContentOnConsole(event: any, productUrlId: number): void {
    console.log('productUrlId: ' + productUrlId);
    this.productUrlService.getContent(productUrlId).subscribe(data => console.log(data));
  }
}
