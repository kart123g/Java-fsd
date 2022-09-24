import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpStoreComponent } from './emp-store.component';

describe('EmpStoreComponent', () => {
  let component: EmpStoreComponent;
  let fixture: ComponentFixture<EmpStoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpStoreComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
