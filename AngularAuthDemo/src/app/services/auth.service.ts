import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      API_URL + 'sign-in',
      {
        username,
        password,
      },
      httpOptions
    );
  }

  register(username: string, email: string, password: string, name: string): Observable<any> {
    return this.http.post(
      API_URL + 'sign-up',
      {
        username,
        email,
        password,
        name
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    return this.http.post(API_URL + 'sign-out', {}, httpOptions);
  }
}
