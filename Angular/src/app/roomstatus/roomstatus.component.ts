import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelService } from '../service/hotel.service';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
import { RouterLinkWithHref, Router, ActivatedRoute } from '@angular/router';
export interface Room {
  roomId: number;
  roomNumber: String;
  roomPrice: number;
  hotel: {
    hotelNameEng: String;
  }
  roomTypeEntity: {
    roomType: String;
  }
  roomStatusEntity: {
    roomStatus: String;
  }
}
@Component({
  selector: 'app-roomstatus',
  templateUrl: './roomstatus.component.html',
  styleUrls: ['./roomstatus.component.css']
})

export class RoomstatusComponent implements OnInit {
  room: Array<any>;
  hotel: Array<any>;
  roomstatus: Array<any>;
  roomtype: Array<any>;
  select: any = {
    inputRoomNumber: '',
    inputRoomPrice: '',
    inputHotel: '',
    inputRoomStatus: '',
    inputRoomType: '',
    selectedRoomId: '',
    selectedRoomStatus: '',
    selectedRoomNumber: '',
    selectedRoomPrice: '',
    selectedRoomType: '',
    selectedHotel: '',
    memberUserName: ''
  }

  displayedColumns: string[] = ['position', 'room_type', 'room_no', 'room_price', 'room_status', 'hotel'];
  dataSource = new RoomDataSource(this.hotelService);
  constructor(private route: ActivatedRoute, private router: Router, private hotelService: HotelService, private httpClient: HttpClient) {
    this.select.memberUserName = this.route.snapshot.paramMap.get('inputUserName');
  }

  ngOnInit() {
    this.hotelService.getHotelNameEng().subscribe(data => {
      this.hotel = data;
      console.log(this.hotel);
    });
    this.hotelService.getRoomStatus().subscribe(data => {
      this.roomstatus = data;
      console.log(this.roomstatus);
    });
    this.hotelService.getRoomType().subscribe(data => {
      this.roomtype = data;
      console.log(this.roomtype);
    });
  }
  selectRow(row) {
    this.select.selectedRoomId = row.roomId;
    this.select.selectedRoomNumber = row.roomNumber;
    this.select.selectedRoomStatus = row.roomStatusEntity.roomStatus;
    this.select.selectedRoomPrice = row.roomPrice;
    this.select.selectedHotel = row.hotel.hotelNameEng;
    this.select.selectedRoomType = row.roomTypeEntity.roomType;
    console.log(this.select.selectedRoomId);
    console.log(this.select.selectedRoomNumber);
    console.log(this.select.selectedRoomStatus);
    console.log(this.select.selectedRoomPrice);
    console.log(this.select.selectedHotel);
    console.log(this.select.selectedRoomType);
  }
  edit() {
    this.select.inputHotel = this.select.selectedHotel;
    if (!this.select.inputRoomNumber)
      this.select.inputRoomNumber = this.select.selectedRoomNumber;
    if (!this.select.inputRoomPrice)
      this.select.inputRoomPrice = this.select.selectedRoomPrice;
    if (!this.select.inputRoomStatus)
      this.select.inputRoomStatus = this.select.selectedRoomStatus;
    if (!this.select.inputRoomType)
      this.select.inputRoomType = this.select.selectedRoomType;

    if (this.select.inputRoomNumber == '')
      alert('Please enter room number');
    else if (this.select.inputRoomPrice == '')
      alert('Please enter room price');
    else if (!Number.isInteger(Number(this.select.inputRoomNumber)))
      alert('Plese check your room number');
    else if (!Number.isInteger(Number(this.select.inputRoomPrice)))
      alert('Plese check your room price');
    else {
      this.httpClient.put('http://localhost:8080/updateroomstatus/' + this.select.selectedRoomId + '/' + this.select.inputHotel + '/' + this.select.inputRoomType + '/' + this.select.inputRoomStatus + '/' + this.select.inputRoomNumber + '/' + this.select.inputRoomPrice, this.select)
        .subscribe(
          data => {
            if (data) {
              this.refresh();
              console.log('Success');
            }

          },
          error => {
            console.log('Uncomplete', error);
          }
        )
    }
  }
  next() {
    this.router.navigate(['/room', this.select.memberUserName]);
  }
  refresh() {
    this.hotelService.getRoom().subscribe((res) => {
      this.room = res;
      this.dataSource = new RoomDataSource(this.hotelService);
    });
  }

}
export class RoomDataSource extends DataSource<any> {
  constructor(private hotelService: HotelService) {
    super();
  }
  connect(): Observable<Room[]> {
    return this.hotelService.getRoom();
  }
  disconnect() { }
}
