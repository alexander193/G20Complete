import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { PromotionService } from '../service/promotion.service';

@Component({
  selector: 'app-login-promotion',
  templateUrl: './login-promotion.component.html',
  styleUrls: ['./login-promotion.component.css']
})
export class LoginPromotionComponent implements OnInit {
  admin: any;
  hide = true;
  select: any = {
    adminUsername: null,
    adminPassword: null
  }
  constructor(private promotionService: PromotionService, private route: ActivatedRoute, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {

  }
  loadAdminData(){
    this.promotionService.getAdminAccount(this.select.adminUsername).subscribe(data => {
      this.admin = data;
      console.log(this.admin);
    });
  }
  login(){
    if(this.select.adminUsername == null || this.select.adminUsername == ''){
      alert('Please Enter Username');
    }else if(this.select.adminPassword == null || this.select.adminPassword == ''){
      alert('Please Enter Password');
    }else{
      if(this.select.adminUsername == this.admin.adminUsername){
        if(this.select.adminPassword == this.admin.adminPassword){
          alert('เข้าสู่ระบบสำเร็จ');
          this.router.navigate(['/promotion']);
        }else{
          alert('รหัสผ่านไม่ถูกต้อง');
        }
      }else{
        alert('ไม่พบบัญชีผู้ใช้');
      }
    }
  }
}
