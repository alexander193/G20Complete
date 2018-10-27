import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }
  getHotelNameEng():Observable<any>{
    return this.http.get(this.API + '/hotels');
  }
  getRoomtype(inputRoomType):Observable<any>{
    return this.http.get(this.API + '/roomtypes/' + inputRoomType);
  }
  getProvinceName(inputHotelNameEng):Observable<any>{
    return this.http.get(this.API+'/hotels/'+inputHotelNameEng);
  }
  getUserName():Observable<any>{
    return this.http.get(this.API+'/users');
  }

}
