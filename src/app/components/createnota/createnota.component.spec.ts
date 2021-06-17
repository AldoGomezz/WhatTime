import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatenotaComponent } from './createnota.component';

describe('CreatenotaComponent', () => {
  let component: CreatenotaComponent;
  let fixture: ComponentFixture<CreatenotaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatenotaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatenotaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
