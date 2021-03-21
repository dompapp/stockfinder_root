import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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
export class ProductFormComponent implements OnInit {



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
    // this.formGroup = fb.group( {
    //   productName: [
    //     Validators.compose( [
    //       Validators.required
    //     ])
    //   ]
    // });
    // tslint:disable-next-line:no-non-null-assertion
    // @ts-ignore
    // this.product = this.productService.createProduct(ProductUtil.createProduct());
    this.product = ProductUtil.createProduct();
    // console.log('log product: ' + this.product);
    // const predefinedFormGroup = {
    //   productName: new FormControl(this.product.productName, Validators.required)
    // };
    this.formGroup = this.fb.group(this.product);
    // console.log(this.formGroup.controls);
  }

  ngOnInit(): void {
    this.formGroup.valueChanges.subscribe(next => {
      this.getDirtyChange.emit(this.formGroup.dirty);
    });
  }

  onSubmit(): void {
    console.log('product name: ' + this.product.productName);
    // this.product.productName = 'new product';
    this.productService.save(this.product).subscribe(result => this.gotoUserList());
  }

  gotoUserList(): void {
    this.router.navigate(['/products']);
  }


}
