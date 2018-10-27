import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable({
  providedIn: 'root'
})
export class PromotionService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getHotelNameEng(): Observable<any> {
    return this.http.get(this.API + '/hotel');
  }
  getRoomId(hotelSelect): Observable<any> {
    return this.http.get(this.API + '/room/getdata/'+hotelSelect);
  }
  getPromotionType(): Observable<any> {
    return this.http.get(this.API + '/promotiontype');
  }
  getAdminAccount(adminUsername): Observable<any> {
    return this.http.get(this.API + '/admin/'+adminUsername);
  }
}
