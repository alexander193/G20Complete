import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelService } from '../service/hotel.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  select: any = {
    inputUserName: '',
    inputPassword: ''
  }
  constructor(private route: ActivatedRoute,private hotelService: HotelService, private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }
  login(){
    if(this.select.inputUserName === '' || this.select.inputPassword === '')
      alert('Please Enter Username and Password')
    else{
      console.log(this.select.inputPassword);
      console.log(this.select.inputUserName);
      this.httpClient.get('http://localhost:8080/memberlogin/' + this.select.inputUserName + '/' + this.select.inputPassword,this.select)
      .subscribe(
          data =>{
            console.log(data);
            if(data){
              this.router.navigate(['/room',this.select.inputUserName]);
            }
            else
              alert('Cannot login Please check your Username Or Password');

          }
)

}
}

}
