import { Component, OnInit } from '@angular/core';
import { ReservationsService } from '../service/reservations.service';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  hotel : Array<any>;
  promotions : Array<any>;
  roomTypes : Array<any>;

  views : any = {
    hotelSelect: '',
    roomTypeSelect: '',
    promotionsSelect: '0',
    numberofpeople: '',
    numberofroom: '',
    dateStart: '',
    dateEnd: '',
    inputEmail: ''

  };
  constructor(private router: Router,private route: ActivatedRoute,private reservationsService: ReservationsService , private httpClient: HttpClient) { 
      this.views.inputEmail = this.route.snapshot.paramMap.get('inputEmail');
  }
  ngOnInit() {
    console.log(this.views.inputEmail);
    this.reservationsService.getHotel_name().subscribe(data => {
      this.hotel = data;
      console.log(this.hotel);
    });
    this.reservationsService.getpromotionsType().subscribe(data => {
      this.promotions = data;
      console.log(this.promotions);
    });
  }
  save() {
   if(this.views.hotelSelect === '') {
      alert('กรุณาเลือกโรงแรม');
    }
    else if(this.views.roomTypeSelect === '') {
     alert('กรุณาเลือกประเภทห้อง');
    }
    else if (this.views.promotionsSelect === '') {
      this.views.promotionsSelect = '1';
    }
    else if (this.views.numberofpeople === '') {
      alert('กรุณาระบุจำนวนคน');
    }
   else if(this.views.numberofroom === '') {
     alert('กรุณาระบุจำนวนห้อง')
   }
    else if (this.views.dateStart === '') {
      alert('กรุณาเลือกวันเช็คอิน');
    }
    else if(this.views.dateEnd === '') {
      alert('กรุณาเลือกวันเช็คเอาท์');

    }else {
      this.httpClient.get('http://localhost:8080/Reservations/'+ this.views.inputEmail + '/' + this.views.hotelSelect + '/' + this.views.roomTypeSelect  +'/'+ this.views.promotionsSelect + '/'+ this.views.numberofpeople + '/' +  this.views.numberofroom + '/' + this.views.dateStart + '/' + this.views.dateEnd, this.views)

        .subscribe(
          data => {
              if(data){
                    console.log('PUT Request is successful');
                    alert('จองสำเร็จ');
                  }
              else
                    alert('ไม่มีห้องว่าง');
          },
          error => {
              console.log('Rrror', error);
          }
      );

    }
  }
  goPaymant(){
    this.router.navigate(['/payment',this.views.inputEmail]);
  }
  goReview(){
    this.router.navigate(['/review',this.views.inputEmail]);
  }
  update_type(){
    this.reservationsService.getRoomId(this.views.hotelSelect).subscribe(data => {
      this.roomTypes = data;
      console.log(this.roomTypes);
    });
  }

  update_promotion(){
    this.reservationsService.getPromotion(this.views.hotelSelect,this.views.roomTypeSelect).subscribe(data => {
      this.promotions = data;
      console.log(this.promotions);
    });

  }

}
