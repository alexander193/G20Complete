import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class ReservationsService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getHotel_name(): Observable<any> {
    return this.http.get(this.API + '/hotel');
  }
  getpromotionsType(): Observable<any> {
    return this.http.get(this.API + '/promotion');
  }
  getRoomId(hotelSelect): Observable<any> {
    return this.http.get(this.API + '/room/getdata/'+hotelSelect);
  }
  getPromotion(hotelSelect,roomTypeSelect): Observable<any>{
    return this.http.get(this.API + '/promotion/getdata/'+hotelSelect+'/'+roomTypeSelect);
  }
    getRoomprice(hotelSelect,roomTypeSelect): Observable<any>{
    return this.http.get(this.API + '/room/getdata/'+hotelSelect+'/'+roomTypeSelect);
  }
}
