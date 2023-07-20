import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  form: any = {
    idProduct: null,
    name: null,
    description: null
  };

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { idProduct, name, description } = this.form;
    if (idProduct) {
      this.updateProduct(idProduct, name, description);
    } else {
      this.createProduct(name, description);
    }
  }

  private createProduct(name: string, description: string): void {
    this.productService.create(name, description).subscribe(product => {
      console.log(product);
    });
  }

  private updateProduct(idProduct: number, name: string, description: string): void {
    this.productService.update(idProduct, name, description).subscribe(product => {
      console.log(product);
    });
  }
}
