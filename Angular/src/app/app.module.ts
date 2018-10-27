import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatTableModule,
MatSidenavModule, MatCheckboxModule } from '@angular/material';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatGridListModule} from '@angular/material/grid-list';
import { MatNativeDateModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { PromotionComponent } from './promotion/promotion.component';
import { PromotionService } from './service/promotion.service';
import { ViewPromotionComponent } from './view-promotion/view-promotion.component';
import { ViewPromotionService } from './service/view-promotion.service';
import { MainComponent } from './main/main.component';
import { ReservationsService } from './service/reservations.service';
import { ReservationsComponent } from './reservations/reservations.component';
import { RoomComponent } from './room/room.component';
import { LoginComponent } from './login/login.component';
import { RoomstatusComponent } from './roomstatus/roomstatus.component';
import { LoginCustomerComponent } from './login-customer/login-customer.component';
import { HotelService } from './service/hotel.service';
import { LoginPromotionComponent } from './login-promotion/login-promotion.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerService } from './service/customer.service';
import { PaymentComponent } from './payment/payment.component';
import { PaymentService } from './service/payment.service';
import { ReviewComponent } from './review/review.component';
import { ReviewService } from './service/review.service';
import {MatRadioModule} from '@angular/material/radio';
import { ViewReviewComponent } from './view-review/view-review.component';
const appRoutes: Routes = [
  {path:'' , component:MainComponent},
  {path:'view-promotion' , component:ViewPromotionComponent},
  {path:'promotion' , component:PromotionComponent},
  {path:'reservations/:inputEmail' , component:ReservationsComponent},
  {path: 'room/:inputUserName', component: RoomComponent},
  {path: 'roomstatus/:inputUserName', component: RoomstatusComponent},
  {path: 'login', component: LoginComponent},
  {path: 'loginCustomer', component: LoginCustomerComponent},
  {path: 'loginPromotion', component: LoginPromotionComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'payment/:inputEmail', component: PaymentComponent},
  {path: 'review/:inputEmail/:selectHotelNameEng/:selectRoomType/:selectReservationId', component: ReviewComponent},
  {path: 'view-review/:inputEmail', component: ViewReviewComponent}
];

@NgModule({
  declarations: [

    AppComponent,
    PromotionComponent,
    ViewPromotionComponent,
    MainComponent,
    ReservationsComponent,
    RoomComponent,
    LoginComponent,
    RoomstatusComponent,
    LoginCustomerComponent,
    LoginPromotionComponent,
    CustomerComponent,
    PaymentComponent,
    ReviewComponent,
    ViewReviewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    MatTableModule,
    MatCheckboxModule,
    MatSidenavModule,
    MatIconModule,
    MatGridListModule,
    MatRadioModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [PromotionService,ViewPromotionService,ReservationsService,HotelService,CustomerService,PaymentService,ReviewService],
  bootstrap: [AppComponent]
})
export class AppModule { }
