import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    // Your authentication logic here
    const isAuthenticated =/* Check if the user is authenticated */true;
    if (isAuthenticated) {
      return true; // Allow access
    } else {
      this.router.navigate(['/login']); // Redirect to the login page
      return false; // Deny access
    }
  }
}
