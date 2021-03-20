import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductFormComponent } from './product-form/product-form.component';
import {ProductUrlListComponent} from './product-url-list/product-url-list.component';

const routes: Routes = [
  { path: 'products', component: ProductListComponent },
  { path: 'urls', component: ProductUrlListComponent },
  { path: 'addproduct', component: ProductFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
