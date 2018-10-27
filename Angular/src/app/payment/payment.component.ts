
import { HttpClient } from '@angular/common/http';
import { PaymentService } from '../service/payment.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html' ,
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  typepayments: Array<any>;
  banks: Array<any>;
  reservations: Array<any>;
  pay: any = {
    firstname : null,
    lastname: null,
    accountnumber: null,
    address: null,
    phonenum: null,
    bank: null,
    typepayment: null,
    reservation: null,
    inputEmail: ''
  };
  constructor(private router: Router,private route: ActivatedRoute,private paymentService: PaymentService, private httpClient: HttpClient) {
    this.pay.inputEmail = this.route.snapshot.paramMap.get('inputEmail');
   }

  ngOnInit() {
    this.paymentService.getBank().subscribe( data => {
      this.banks = data;
      console.log(this.banks);
    });
    this.paymentService.getTypepayment().subscribe(data => {
      this.typepayments = data;
      console.log(this.typepayments);
    });

    this.paymentService.getReservation(this.pay.inputEmail).subscribe(data => {
      this.reservations = data;
      console.log(this.reservations);
    });

  }
  goReview(){
    this.router.navigate(['/view-review',this.pay.inputEmail]);
  }
  save() {
    if (this.pay.firstname == null || this.pay.firstname == '' || this.pay.lastname == null || this.pay.address == '' || this.pay.phonenum == null || this.pay.phonenum == '' || this.pay.reservation == null
      || this.pay.lastname == '' || this.pay.accountnumber == null || this.pay.accountnumber == '' || this.pay.address == null || this.pay.bank == null || this.pay.typepayment == null) {
        alert('กรุณาเลือกและกรอกข้อมูลให้ครบถ้วน');
    } else if(!Number.isInteger(Number(this.pay.phonenum)) || !Number.isInteger(Number(this.pay.accountnumber))) {
        alert('กรุณากรอกข้อมูลให้ถูกต้อง');
    } else {
    this.httpClient.get('http://localhost:8080/payment/' + this.pay.inputEmail + '/' +  this.pay.accountnumber + '/' + this.pay.firstname + '/' + this.pay.lastname +
    '/' + this.pay.address + '/' + this.pay.phonenum + '/' + this.pay.bank +
    '/' +  this.pay.typepayment + '/' + this.pay.reservation, this.pay).subscribe(
      data => {
          if(!data){
            alert("กรุณากรอกหมายเลขบัญชีหรือเลือกธนาคารให้ถูกต้อง");
          }
          else{
            alert("ชำระเงินสำเร็จ");
            location.reload();
          }

      },
      error => {
          console.log('Rrror', error);
      }
  );
  }
  }

}
