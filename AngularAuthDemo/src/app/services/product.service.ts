import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';

const API_URL = 'http://localhost:8080/api/products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(API_URL).pipe(
      catchError(ex => {
        return throwError(() => ex);
      })
    );
  }

  getById(id: number): Observable<any> {
    return this.http.get<any>(API_URL + `/${id}`).pipe(
      catchError(ex => {
        return throwError(() => ex);
      })
    );
  }
  
  create(name: string, description: string): Observable<any> {
    return this.http.post<any>(API_URL, {name, description}).pipe(
      catchError(ex => {
        return throwError(() => ex);
      })
    );
  }
  
  update(idProduct: number, name: string, description: string): Observable<any> {
    return this.http.put<any>(API_URL, {idProduct, name, description}).pipe(
      catchError(ex => {
        return throwError(() => ex);
      })
    );
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(API_URL + `/${id}`).pipe(
      catchError(ex => {
        return throwError(() => ex);
      })
    );
  }
}
