import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from '../service/hotel.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-customer',
  templateUrl: './login-customer.component.html',
  styleUrls: ['./login-customer.component.css']
})
export class LoginCustomerComponent implements OnInit {
  select: any = {
    inputEmail: '',
    inputPassword: ''
  }
  constructor(private route: ActivatedRoute, private hotelService: HotelService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
  }
  login() {
    if (this.select.inputEmail === '' || this.select.inputPassword === '')
      alert('Please Enter Username and Password')
    else {
      console.log(this.select.inputPassword);
      console.log(this.select.inputEmail);
      this.httpClient.get('http://localhost:8080/customerlogin/' + this.select.inputEmail + '/' + this.select.inputPassword, this.select)
        .subscribe(
          data => {
            console.log(data);
            if (data)
              this.router.navigate(['/reservations', this.select.inputEmail]);
            else
              alert('Cannot login Please check your Email Or Password');
          },
        )

    }
  }
}