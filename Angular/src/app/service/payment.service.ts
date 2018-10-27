import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }
  getBank():  Observable<any> {
    return this.http.get(this.API + '/BankEntity');
  }
  getTypepayment(): Observable<any> {
    return this.http.get(this.API + '/TypepaymentEntity');
  }
  getReservation(inputEmail): Observable<any> {
    console.log(inputEmail);
    return this.http.get(this.API + '/Reservations/' + inputEmail);
  }
}
