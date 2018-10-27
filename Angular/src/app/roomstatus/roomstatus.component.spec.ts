import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomstatusComponent } from './roomstatus.component';

describe('RoomstatusComponent', () => {
  let component: RoomstatusComponent;
  let fixture: ComponentFixture<RoomstatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomstatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomstatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
