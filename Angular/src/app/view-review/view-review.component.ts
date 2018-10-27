import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { HotelService } from '../service/hotel.service';
import { Observable } from 'rxjs/Observable';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
export interface Reservation {
  reservationsId: number;
  hoteltype: {
    hotelNameEng: String;
  }
  statusPaymentEntity: {
    status: String;
  }
  roomTypeEntity:{
    roomType: String;
  }
}

@Component({
  selector: 'app-view-review',
  templateUrl: './view-review.component.html',
  styleUrls: ['./view-review.component.css']
})
export class ViewReviewComponent implements OnInit {
  select: any = {
    selectHotelNameEng: '',
    selectRoomType: '',
    selectReservationId: ''
  }
  inputEmail: String;
  
  constructor(private router: Router, private route: ActivatedRoute, private hotelService: HotelService, private httpClient: HttpClient) { 
    this.inputEmail = this.route.snapshot.paramMap.get('inputEmail');
  }
  displayedColumns: string[] = ['reservationId', 'HotelName', 'status','roomType'];
  dataSource = new ReservationDataSource(this.route,this.hotelService);
  ngOnInit() {

  }
  review(){
    this.router.navigate(['/review',this.inputEmail, this.select.selectHotelNameEng,this.select.selectRoomType,this.select.selectReservationId]);
  }
  selectRow(row){
      this.select.selectHotelNameEng  = row.hoteltype.hotelNameEng;
      this.select.selectRoomType  = row.roomTypeEntity.roomType;
      this.select.selectReservationId  = row.reservationsId;
      console.log(this.select.selectHotelNameEng);
      console.log(this.select.selectRoomType);
      console.log(this.select.selectReservationId);
  }

}
export class ReservationDataSource extends DataSource<any> {
  constructor(private route: ActivatedRoute,private hotelService: HotelService) {
    super();
  }
  Email = this.route.snapshot.paramMap.get('inputEmail');;
  
  connect(): Observable<Reservation[]> {
    console.log(this.hotelService.getReservation(this.Email));
    return this.hotelService.getReservation(this.Email);
  }
  disconnect() { }
}