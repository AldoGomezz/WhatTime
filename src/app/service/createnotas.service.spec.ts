import { TestBed } from '@angular/core/testing';

import { CreatenotasService } from './createnotas.service';

describe('CreatenotasService', () => {
  let service: CreatenotasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreatenotasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
