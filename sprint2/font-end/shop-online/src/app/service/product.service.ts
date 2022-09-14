import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const APL_URL = `${environment.apiUrl}`;

class Category {
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) {
  }

  getAll(page: number, searchName) {
    let productName;

    if (searchName == null) {
      productName = '';
    } else {
      productName = searchName;
    }
    return this.httpClient.get<Product[]>(this.URL_CONNECT + '/products?page=' + page + '&searchName=' + productName);
  }

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.URL_CONNECT + '/product/create', product);
  }

  editProduct(product: Product): Observable<Product> {
    return this.httpClient.patch<Product>(this.URL_CONNECT + '/product/edit', product);
  }

  findById(id): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_CONNECT + '/findById/' + id);
  }

  deleteProduct(id) {
    return this.httpClient.delete(this.URL_CONNECT + '/delete/' + id);
  }

  getAllCategory() {
    return this.httpClient.get<Category[]>(this.URL_CONNECT + '/category');
  }

  getPhone() {
    return this.httpClient.get(this.URL_CONNECT + '/phone');
  }

  getLaptop() {
    return this.httpClient.get(this.URL_CONNECT + '/laptop');
  }

  getTivi() {
    return this.httpClient.get(this.URL_CONNECT + '/tivi');
  }

  getCamera() {
    return this.httpClient.get(this.URL_CONNECT + '/camera');
  }

  getDevice() {
    return this.httpClient.get(this.URL_CONNECT + '/device-sup');
  }
}
