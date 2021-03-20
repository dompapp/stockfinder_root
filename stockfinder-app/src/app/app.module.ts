import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ProductFormComponent } from './product-form/product-form.component';
import {ProductListComponent} from './product-list/product-list.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing-module';
import {ProductService} from './service/product.service';
import { ProductUrlListComponent } from './product-url-list/product-url-list.component';
import {ProductUrlService} from './service/product-url.service';
import {ManufacturerService} from './service/manufacturer-service.service';


@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductFormComponent,
    ProductUrlListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ManufacturerService, ProductService, ProductUrlService],
  bootstrap: [AppComponent]
})
export class AppModule { }
