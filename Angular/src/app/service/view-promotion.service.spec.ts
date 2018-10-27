import { TestBed, inject } from '@angular/core/testing';

import { ViewPromotionService } from './view-promotion.service';

describe('ViewPromotionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ViewPromotionService]
    });
  });

  it('should be created', inject([ViewPromotionService], (service: ViewPromotionService) => {
    expect(service).toBeTruthy();
  }));
});
