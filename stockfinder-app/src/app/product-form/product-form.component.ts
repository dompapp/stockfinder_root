import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  product: Product;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: ProductService) {
    this.product = new Product();
  }

  onSubmit() {
    this.userService.save(this.product).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/products']);
  }

  ngOnInit(): void {
  }

}
