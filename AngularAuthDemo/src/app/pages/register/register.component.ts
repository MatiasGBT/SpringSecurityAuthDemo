import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null,
    name: null
  };
  isSuccessful = false;
  errorMessage = '';

  constructor(private authService: AuthService, private storageService: StorageService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username, email, password, name } = this.form;
    this.authService.register(username, email, password, name).subscribe({
      next: data => {
        console.log(data);
        this.isSuccessful = true;
        this.loginAfterSignUp(username, password);
      },
      error: err => {
        this.errorMessage = err.error.detail;
        this.isSuccessful = false;
      }
    });
  }

  private loginAfterSignUp(username: string, password: string): void {
    this.authService.login(username, password).subscribe({
      next: data => {
        this.storageService.saveUser(data);
        this.router.navigate(['/home']);
      },
      error: err => {
        this.errorMessage = err.error.detail;
      }
    });
  }
}
