import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductUrlListComponent } from './product-url-list.component';

describe('ProductUrlListComponent', () => {
  let component: ProductUrlListComponent;
  let fixture: ComponentFixture<ProductUrlListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductUrlListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductUrlListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
