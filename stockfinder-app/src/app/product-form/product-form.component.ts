import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductUtil} from '../util/product-util';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit, OnChanges {



  @Output()
  getDirtyChange = new EventEmitter<boolean>();

  @Input()
  product: Product;
  formGroup: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService,
    private fb: FormBuilder) {
    this.product = ProductUtil.createProduct();
    this.formGroup = this.fb.group(this.product);
    console.log(this.formGroup.controls);
  }

  ngOnInit(): void {
    this.formGroup.valueChanges.subscribe(next => {
      this.getDirtyChange.emit(this.formGroup.dirty);
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.product) {
      this.formGroup = this.fb.group(this.product);
    } else {
      console.error('row is empty');
    }
  }

  onSubmit(): void {
    this.productService.save(this.product).subscribe(result => this.gotoUserList());
  }

  gotoUserList(): void {
    this.router.navigate(['/products']);
  }


}
